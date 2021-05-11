package vendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

class ChangesModuleTest {
    @Test //JUnit5에서는 @Test 붙인 메서드에서 public이 필수가 아니고, JUnit5 가이드에서는 public이 없이 나와있어서 빼도 된다.
    void 자판기_생성(){
        ChangesModule changesModule = new ChangesModule();
        Assertions.assertThat(changesModule).isNotNull();
    }

/*    @Test
    void 자판기에_500원을_넣으면_500원이_들었는지_알_수_있다(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.put(500);
        Assertions.assertThat(vendingMachine.getChanges()).isEqualTo(500);
    }

    @Test
    void 자판기에_1000원을_넣으면_1000원이_들었는지_알_수_있다(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.put(1000);
        Assertions.assertThat(vendingMachine.getChanges()).isEqualTo(1000);
    }*/

    @ParameterizedTest (name = "자판기에_{0}원을_넣으면_{0}원이_들었는지_알_수_있다")//왜 안 되나... 돌아벌렬
    @valueSource(ints = {500, 1000})
    void 자판기에_n원을_넣으면_n원이_들었는지_알_수_있다(int changes){
        ChangesModule changesModule = new ChangesModule();
        changesModule.put(changes);
        Assertions.assertThat(changesModule.getChanges()).isEqualTo(500);
    }

    @Test
    @Disabled
    void _1000원이_들어있는_자판기에_500원을_넣으면_1500원이_들었는지_알_수_있다(){
        ChangesModule changesModule = new ChangesModule(1000);
        changesModule.put(500);
        Assertions.assertThat(changesModule.getChanges()).isEqualTo(500);
    }


    @Test
    void _500원이_들어있는_자판기_500원을_차감하면_0원이_된다(){
        ChangesModule changesModule = new ChangesModule(1000);
        changesModule.withdraw(-500);
        Assertions.assertThat(changesModule.getChanges()).isEqualTo(0);
    }

    @Test
    void _0원이_들어있는_자판기_500원을_차감할_수_없다(){
        ChangesModule changesModule = new ChangesModule(1000);
        changesModule.withdraw(-500);
        Assertions.assertThat(changesModule.getChanges()).isEqualTo(0);
        Assertions.assertThatIllegalStateException().isThrownBy(
                ()-> changesModule.withdraw(500));
    }
}
