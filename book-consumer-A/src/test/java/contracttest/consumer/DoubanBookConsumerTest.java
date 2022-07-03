package contracttest.consumer;

import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.example.bookconsumera.BookConsumerAApplication;
import com.example.bookconsumera.BookServiceClient;
import com.example.bookconsumera.DoubanBookResponse;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = BookConsumerAApplication.class)
public class DoubanBookConsumerTest {

    @Autowired
    private BookServiceClient client;

    @Pact(consumer = "doubanServiceConsumer", provider = "bookServiceProvider")
    RequestResponsePact getBookById(@NotNull PactDslWithProvider builder) {
        var doubanBookResponse = DoubanBookResponse.builder()
                .title("《Java从入门到放弃》")
                .authors(
                        List.of(
                                DoubanBookResponse.Author.builder()
                                        .name("张三")
                                        .company("Thoughtworks")
                                        .build(),
                                DoubanBookResponse.Author.builder()
                                        .name("李四")
                                        .company("Google")
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
                .body(new Gson().toJson(doubanBookResponse))
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "getBookById", port = "9101")
    void getBookByIdTest() {
        var book = client.getBook(1L);

        assertThat(book)
                .returns("《Java从入门到放弃》", DoubanBookResponse::getTitle);
    }
}
