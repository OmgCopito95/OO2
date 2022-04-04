import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


// hereda de VoorheesExporter
public class JSONSimpleAdapter extends VoorheesExporter {

    JSONObject jsonObject;
    JSONArray jsonArray;


	private JSONObject exportar(Socio socio) {
        jsonObject = new JSONObject();
        jsonObject.put("nombre", socio.getNombre());
        jsonObject.put("email", socio.getEmail());
        jsonObject.put("legajo", socio.getLegajo());
		
		return jsonObject;
	}

	public String exportar(List<Socio> socios) {
		if (socios.isEmpty()) {
			return "[]";
		}
        jsonArray = new JSONArray();
        for (Socio socio : socios) {
            jsonArray.add(exportar(socio));
        }

		return jsonArray.toJSONString();
	}
}
