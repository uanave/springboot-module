package academy.everyonecodes.tinybusiness.scheduler;

import academy.everyonecodes.tinybusiness.logic.ShopService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
@EnableScheduling
public class OpenCloseStoreSchedule {
    private final ShopService shopService;

    public OpenCloseStoreSchedule(ShopService shopService) {
        this.shopService = shopService;
    }

    @Scheduled(cron = "${tiny-business.scheduling.opening}")
    public void openStore() {
        shopService.open();
        System.out.println(
                "The store is open! - " + LocalDateTime.now());
    }

    @Scheduled(cron = "${tiny-business.scheduling.closing}")
    public void closeStore() {
        shopService.close();
        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "The store is closed! - " + LocalDateTime.now());
    }

    @Scheduled(cron = "0/5 * * ? * MON-FRI")
    public void openStore10Seconds() {
        if (shopService.isOpen()) {
            shopService.close();
            System.out.println(
                    "The shop is closed - " + LocalTime.now());
        } else {
            shopService.open();
            System.out.println(
                    "The shop is open - " + LocalTime.now());
        }
    }
}
