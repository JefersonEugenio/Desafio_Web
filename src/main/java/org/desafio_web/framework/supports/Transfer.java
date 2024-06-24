package org.desafio_web.framework.supports;

import com.aventstack.extentreports.Status;
import org.desafio_web.framework.data.EncapsulationData;
import org.desafio_web.framework.utils.ObjectsUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static org.desafio_web.framework.tools.Report.extentTest;

public class Transfer {

    public static EncapsulationData user = new EncapsulationData();
    public static DecimalFormatSymbols simbolo = new DecimalFormatSymbols(Locale.getDefault());
    public static DecimalFormat df = new DecimalFormat("#,##0.00", simbolo);

    public static String value() {
        Fakers fakers = new Fakers();
        double value = fakers.getValue();
        String valueStr = Double.toString(value);
        String dfValueStr = df.format(value);
        ObjectsUtils.setPropertiesData("dados", "Value_transfer", dfValueStr);
        extentTest.log(Status.INFO, "Transferencia valor é " + dfValueStr);
        return valueStr;
    }

    public static String transfer(String user1Balance, String user2Balance, String valueTransfer) {
        System.out.println("RESULT user 1 value: " + sacar(user1Balance, valueTransfer));
        System.out.println("RESULT user 2 value: " + depositar(user2Balance, valueTransfer));
        return null;
    }

    public static String depositar(String balance, String valueTransfer) {
        balance = balance.replace(".", "").replace(",", ".");
        double balanceDouble = Double.parseDouble(balance);
        double valueTransferDouble = Double.parseDouble(valueTransfer);
        if (valueTransferDouble > 0) {
            System.out.println("=======");
            System.out.println("A Conta 2 tem valor default: " + df.format(balanceDouble));
            System.out.println("A conta 2 recebeu o valor de " + df.format(valueTransferDouble).replace(".", ",") + " conta 1.");
            System.out.println("TOTAL o valor de " + df.format(balanceDouble + valueTransferDouble));
            extentTest.log(Status.INFO, "A conta 2 recebeu o valor de " + valueTransfer.replace(".", ",") + " conta 1");
            return df.format(balanceDouble += valueTransferDouble);
        }
        return null;
    }

    public static String sacar(String balance, String valueTransfer) {
        balance = balance.replace(".", "").replace(",", ".");
        double balanceDouble = Double.parseDouble(balance);
        double valueTransferDouble = Double.parseDouble(valueTransfer);
        System.out.println("Double balanceDouble: " + balanceDouble);
        System.out.println("Double valueTransferDouble: " + valueTransferDouble);
        if (valueTransferDouble > 0 && valueTransferDouble <= balanceDouble) {
            System.out.println("-----");
            System.out.println("A Conta 1 tem valor default: " + df.format(balanceDouble));
            System.out.println("A conta 1 sacou o valor de " + df.format(valueTransferDouble) + " e depositou na conta 2.");
            System.out.println("A conta 1 total o valor de " + df.format(balanceDouble - Double.parseDouble(valueTransfer)));
            extentTest.log(Status.INFO, "A conta 1 sacou valor de " + valueTransfer.replace(".", ",") + " e depositou na conta 2");
            return df.format(balanceDouble -= valueTransferDouble);
        }
        return null;
    }

}