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

    public static void transfer(String user1Balance, String user2Balance, String valueTransfer) {
        sacar(user1Balance, valueTransfer);
        depositar(user2Balance, valueTransfer);
    }

    public static String depositar(String balance, String valueTransfer) {
        balance = balance.replace(".", "").replace(",", ".");
        double balanceDouble = Double.parseDouble(balance);
        double valueTransferDouble = Double.parseDouble(valueTransfer);
        if (valueTransferDouble > 0) {
            extentTest.log(Status.INFO, "A conta 2 recebeu o valor de " + valueTransfer.replace(".", ",") + " conta 1");
            return df.format(balanceDouble += valueTransferDouble);
        }
        return null;
    }

    public static void sacar(String balance, String valueTransfer) {
        balance = balance.replace(".", "").replace(",", ".");
        double balanceDouble = Double.parseDouble(balance);
        double valueTransferDouble = Double.parseDouble(valueTransfer);
        if (valueTransferDouble > 0 && valueTransferDouble <= balanceDouble) {
            extentTest.log(Status.INFO, "A conta 1 sacou valor de " + valueTransfer.replace(".", ",") + " e depositou na conta 2");
        }
    }

}