package vendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoinTest {

    @Test
    void 동전을_생성한다(){
        Coin coin = new Coin(100);
        Assertions.assertThat(coin).isNotNull();
    }
    @ParameterizedTest
    @ValueSource(ints = {500, 100, 50, 10})
    void 동전은_500원_100원_50원_10원이_있다(int value){
        Coin coin = new Coin(value);
        Assertions.assertThat(coin).isEqualTo(new Coin(value));
/*        Coin _500krw = new Coin(500);
        Assertions.assertThat(_500krw).isEqualTo(new Coin(500));
        Coin _100krw = new Coin(100);
        Assertions.assertThat(_500krw).isEqualTo(new Coin(100));
        Coin _50krw = new Coin(50);
        Assertions.assertThat(_50krw).isEqualTo(new Coin(50));
        Coin _10krw = new Coin(10);
        Assertions.assertThat(_10krw).isEqualTo(new Coin(10));*/
    }
    @ParameterizedTest
    @ValueSource(ints = {500, 100, 50, 10})
    void 존재하지_않는_동전을_정의한다(int value){
        Coin coin = new Coin(value);
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(()-> new Coin(value));
    }
}
