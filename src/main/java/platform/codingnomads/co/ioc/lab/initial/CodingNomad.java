package platform.codingnomads.co.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {

    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;

    //Field Injection
    @Autowired
    private OperatingSystem operatingSystem;
    private KeyBoardType keyBoardType;

    @Autowired
    public void setKeyBoardType(KeyBoardType keyBoardType){
        this.keyBoardType = keyBoardType;
    }

    public String createAwesomeSoftware() {
        return MessageFormat
                .format("This coding nomad is creating awesome software using, " +
                                "IDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5})",
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion()
                );
    }
    public String additionalItems(){
        return MessageFormat.format("This computer has the following configurations: " +
                        "OperationSystem: ({0}:{1}), KeyBoardType: ({2}:{3})",
                operatingSystem.getName(), operatingSystem.getVersion(),
                keyBoardType.getName(), keyBoardType.getVersion());
    }
    //Setter Injection

}
