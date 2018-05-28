package com.pe.mongoDb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.util.JSON;
import com.pe.model.Customer;

public class CustomerLoader {

	public static void main(String[] args) throws IOException, JSONException {
		obtenerCliente();
	}

	public static void obtenerCliente() throws IOException, JSONException {

		MongoClient client = null;
		String fileName = "";
		File f = null;

		try {
			f = new File("C:\\Users\\lloyolan\\Desktop\\CargaPremiaMongo\\customer0117.csv");
			fileName = f.getName();
			String newfileName = fileName.replaceAll(".csv", "").trim();
			MongoClientURI mongoClient = new MongoClientURI(
					"");
			client = new MongoClient(mongoClient);
			MongoDatabase db = client.getDatabase("premia");
			//FileReader fileReader = new FileReader("C:\\Users\\lloyolan\\Desktop\\CargaPremiaMongo\\customer0117.csv");
	
			MongoCollection<BasicDBObject> collection = db.getCollection(newfileName, BasicDBObject.class);
			IndexOptions indexOptions = new IndexOptions().unique(true);
			collection.createIndex(Indexes.ascending("customerId"), indexOptions);
			Scanner s = new Scanner((Readable) new BufferedReader(
				    new InputStreamReader(new FileInputStream(f),"ISO-8859-1")));
			s.useDelimiter("\n");
			String cadena = "";
			while (s.hasNext()) {
				String registro = s.next();
				cadena = cadena + registro;
				
			}
			s.close();
			
			JSONArray array = CDL.toJSONArray(cadena);
			
			for (int n = 0; n < array.length(); n++) {
				JSONObject object = array.getJSONObject(n);
				Iterator llaves = object.keys();
				String registro = "";
				while (llaves.hasNext()) {
					registro = convertirArreglo(object, llaves.next().toString());
					object = new JSONObject(registro);
				
				}

				Customer customer = new ObjectMapper().readValue(registro, Customer.class);
				JSONObject objetoFinal = new JSONObject(customer);
				BasicDBObject obj = (BasicDBObject) JSON.parse(objetoFinal.toString());
				try {
					collection.insertOne(obj);
					System.out.println("Done");
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		} finally {
			if (client != null) {
				client.close();
			}

		}
	}

	public static String convertirPerfiles(String cadena, String profiles) {
		if (!cadena.trim().isEmpty()) {
			if (profiles.contains("*")) {
				String newProfile = "[" + profiles.replace("*", ",") + "]";
				cadena = cadena.replace(profiles, newProfile);
			}
			return cadena;
		}
		return null;
	}

	public static String convertirArreglo(JSONObject jsonBase, String campo) throws JSONException {
		String profiles = jsonBase.get(campo).toString();
		String registro = jsonBase.toString();
		registro = convertirPerfiles(registro, profiles);
		registro = registro.replace("\"[", "[");
		registro = registro.replace("]\"", "]");
		return registro;
	}
}