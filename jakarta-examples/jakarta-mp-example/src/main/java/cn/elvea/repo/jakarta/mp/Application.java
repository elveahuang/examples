package cn.elvea.repo.jakarta.mp;

import fish.payara.micro.BootstrapException;
import fish.payara.micro.PayaraMicro;

public class Application {

    public static void main(String[] args) throws BootstrapException {
        PayaraMicro.bootstrap();
    }

}
