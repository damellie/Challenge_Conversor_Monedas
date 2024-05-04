import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaMoneda  implements  Conversion{
    private String base;
    private String target;

    public ConsultaMoneda(String base, String target) {
        this.base = base;
        this.target = target;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Moneda convierteMoneda (float amount){
        var url= URI.create("https://v6.exchangerate-api.com/v6/8f448da73e7d747caf689c5b/pair/"+this.base+
                "/"+this.target+"/"+amount);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = null; //Al meter el return dentro del try esta linea ya no tiene que ir fuera del try
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //Las siguientes lineas las metemos dentro del try
            String json = response.body();
            Moneda miMoneda =  new Gson().fromJson(json, Moneda.class);
            return miMoneda ;
            // si lo dejamos fuera puede que el try arroje el error e intentariamos retornar algo incorrecto
        } catch (Exception e) {
            throw new RuntimeException("No pude convertir la cifra especificada");
        }

    }

    public void mostrarConversion (float cantidad,Conversion conversion, Moneda miMoneda){
        System.out.println(cantidad + "[" + this.base + "]" + " --> " + conversion.getConversion(miMoneda) +
                "["+this.target+"]");
    }

    @Override
    public float getConversion(Moneda moneda) {

        return moneda.conversion_result();
    }
}
