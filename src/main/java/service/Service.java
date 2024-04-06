package service;

import event.EventBase;
import event.EventFood;
import event.EventLiquidFood;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;
import model.Food;
import model.LiquidFood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static jakarta.enterprise.event.TransactionPhase.AFTER_SUCCESS;

@ApplicationScoped
public class Service {

    private final Logger log = LoggerFactory.getLogger(Service.class);

    public void processEventBase(@Observes EventBase event) {
        log.info(event.toString());
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void processEventFood(@Observes(during = AFTER_SUCCESS) final EventFood event) {
        Food food = new Food(event.getFood(), event.getWeight(), event.getPersonId(), event.getDatetime());
        try {
            food.persist();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void processEventLiquidFood(@Observes(during = AFTER_SUCCESS) final EventLiquidFood event) {
        LiquidFood food = new LiquidFood(event.getLiquid(), event.getAmount(), event.getPersonId(), event.getDatetime());
        try {
            food.persist();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
