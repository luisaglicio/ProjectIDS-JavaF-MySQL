package model.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;

public class AlunoService {

	private AlunoDao dao = DaoFactory.createAlunoDao();
	
	public List<Aluno> findAll() {
		
		//Implementado para o JFX a chamada para a API
		List<Aluno> alunos = null;
		try {
			String url = "http://localhost:8080/aluno";

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }
            System.out.println(output);
            conn.disconnect();
            
            Gson gson = new Gson();
            alunos = gson.fromJson(output, new TypeToken<List<Aluno>>(){}.getType());
            
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return alunos;
		
	}
	
	public void saveOrUpdate(Aluno obj) {
		
		//antiga chamada sem o Post
		/*		
		if (obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}*/
		
		//Implementação do POST
		try {
							        	        
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create("http://localhost:8080/saveAluno"))
	                .POST(HttpRequest.BodyPublishers.ofString(obj.getName()))
	                .build();

	        HttpResponse<String> response = client.send(request,
	                HttpResponse.BodyHandlers.ofString());

	        System.out.println(response.body());
			

           
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void remove(Aluno obj) {
		//chamada antiga antes do POST		
		//dao.deleteById(obj.getId());
		
		//Implementação do POST
		try {
	        
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create("http://localhost:8080/deleteAluno"))
	                .POST(HttpRequest.BodyPublishers.ofString(obj.getId().toString()))
	                .build();

	        HttpResponse<String> response = client.send(request,
	                HttpResponse.BodyHandlers.ofString());

	        System.out.println(response.body());
			

           
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}