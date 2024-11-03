package app.managedBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ManagedBean(name = "appBean")
@ViewScoped
public class AppBean  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String appVersion;
    //private LuaReader luaReader;

    private int numberCount = 0;

    public void incrementCounter(ActionEvent event) {
        numberCount++;
    }

    public void decrementCounter(ActionEvent event) {
        numberCount--;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public void setNumberCount(int numberCount) {
        this.numberCount = numberCount;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

}
