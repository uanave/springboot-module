package academy.everyonecodes.tinybusiness.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    private boolean isOpen = true;
    private String messageOpen;
    private String messageClosed;

    public ShopService(@Value("${tiny-business.open}") String messageOpen,
                       @Value("${tiny-business.close}")String messageClosed) {
        this.messageOpen = messageOpen;
        this.messageClosed = messageClosed;
    }

    public ShopService() {
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String close() {
        setOpen(false);
        return messageClosed;
    }

    public String open() {
        setOpen(true);
        return messageOpen;
    }
}
