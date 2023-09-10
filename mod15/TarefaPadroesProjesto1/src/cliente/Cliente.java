package cliente;

public class Cliente {

    private String valeCarro;
    private boolean isGovernamental;

    public Cliente(String valeCarro, boolean isGovernamental) {
        this.valeCarro = valeCarro;
        this.isGovernamental = isGovernamental;
    }

    public String getValeCarro() {
        return valeCarro;
    }

    public boolean isGovernamental() {
        return isGovernamental;
    }
}
