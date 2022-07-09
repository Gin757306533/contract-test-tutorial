package contracttest.consumer;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.example.bookconsumera.BookConsumerAApplication;
import com.example.bookconsumera.BookServiceClient;
import com.example.bookconsumera.DoubanBookResponse;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactConsumerTestExt.class)
@SpringBootTest(classes = BookConsumerAApplication.class)
@ActiveProfiles("contract-test")
public class DoubanBookConsumerTest {

    @Autowired
    private BookServiceClient client;

    @Pact(consumer = "doubanServiceConsumer", provider = "bookServiceProvider")
    RequestResponsePact getBookById(@NotNull PactDslWithProvider builder) {
        var doubanBookResponse = DoubanBookResponse.builder()
                .title("Effective Java")
                .authors(
                        List.of(
                                DoubanBookResponse.Author.builder()
                                        .name("Joshua Bloch")
                                        .company("Sun Microsystems & Google")
                                        .build()
                        )
                )
                .build();
        return builder.given("get douban book info by id")
                .uponReceiving("get douban book info by id")
                .method("GET")
                .path("/books/1")
                .willRespondWith()
                .status(HttpStatus.OK.value())
                .matchHeader("Content-Type", "application/json")
                .body(new Gson().toJson(doubanBookResponse))
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "getBookById", port = "9101")
    void getBookByIdTest() {
        var book = client.getBook(1L);

        assertThat(book)
                .returns("Effective Java", DoubanBookResponse::getTitle);
        assertThat(book.getAuthors())
                .satisfiesExactly(
                        it -> assertThat(it)
                                .returns("Joshua Bloch", DoubanBookResponse.Author::getName)
                                .returns("Sun Microsystems & Google", DoubanBookResponse.Author::getCompany)
                );
    }
}
