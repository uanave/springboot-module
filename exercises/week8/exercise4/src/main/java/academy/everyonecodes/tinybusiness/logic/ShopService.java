package academy.everyonecodes.tinybusiness.logic;

import org.springframework.stereotype.Service;

@Service
public class ShopService {
    private boolean isOpen = true;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String close() {
        setOpen(false);
        return "Shop is now closed";
    }

    public String open() {
        setOpen(true);
        return "Shop is now open";
    }


}
