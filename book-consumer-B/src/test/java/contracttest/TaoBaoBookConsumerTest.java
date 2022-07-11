package contracttest;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.example.bookconsumerb.BookConsumerBApplication;
import com.example.bookconsumerb.BookServiceClient;
import com.example.bookconsumerb.TaoBaoBookResponse;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactConsumerTestExt.class)
@SpringBootTest(classes = BookConsumerBApplication.class)
@ActiveProfiles("contract-test")
public class TaoBaoBookConsumerTest {

    @Autowired
    private BookServiceClient client;

    @Pact(consumer = "taobaoServiceConsumer", provider = "bookServiceProvider")
    RequestResponsePact getBookById(@NotNull PactDslWithProvider builder) {
        var doubanBookResponse = TaoBaoBookResponse.builder()
                .title("Effective Java")
                .price(49.49f)
                .build();
        return builder
                .uponReceiving("get taobao book info by id")
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
                .returns("Effective Java", TaoBaoBookResponse::getTitle)
        .returns(49.49f, TaoBaoBookResponse::getPrice);
    }
}
