package com.example.imagetodatabaseviawebservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalBase64;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Base64;

public class UsuarioDAO {

	private static final String URL = "http://192.168.0.9:8080/WebServiceDatabaseAndImages/services/UsuarioDAO?wsdl";
	private static final String NAMESPACE = "http://imagem.exemplowebservice.luiszeni.com.br";

	private static final String INSERIR = "inserirUsuario";
	private static final String BUSCAR_TODOS = "buscarTodosUsuarios";
	private static final String BUSCAR_POR_ID = "buscaUsuarioPorId";
	private static final String EXCLUIR_USUARIO_POR_ID = "excluirUsuario";

	public Usuario inserirUsuario(Usuario usuario) {

		SoapObject inserirUsuario = new SoapObject(NAMESPACE, INSERIR);

		SoapObject usr = new SoapObject(NAMESPACE, "usuario");
		usr.addProperty("id", usuario.getId());
		usr.addProperty("idade", usuario.getIdade());
		usr.addProperty("nome", usuario.getNome());
		usr.addProperty("foto", usuario.getFoto());

		inserirUsuario.addSoapObject(usr);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

		envelope.setOutputSoapObject(inserirUsuario);
		
		new MarshalBase64().register(envelope);
		
		envelope.implicitTypes = true;

		HttpTransportSE http = new HttpTransportSE(URL);

		try {
			http.call("urn:" + INSERIR, envelope);

			SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();

			int id = Integer.parseInt(resposta.toString());

			if (id > 0) {
				usuario.setId(id);
				return usuario;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public Usuario busarUsuarioPorID(int id) {
		Usuario usr = null;

		SoapObject buscarUsuarios = new SoapObject(NAMESPACE, BUSCAR_POR_ID);
		buscarUsuarios.addProperty("id", id);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

		envelope.setOutputSoapObject(buscarUsuarios);

		envelope.implicitTypes = true;

		HttpTransportSE http = new HttpTransportSE(URL);

		try {
			http.call("urn:" + BUSCAR_POR_ID, envelope);

			SoapObject resposta = (SoapObject) envelope.getResponse();

			usr = new Usuario();

			usr.setId(Integer.parseInt(resposta.getProperty("id").toString()));
			usr.setNome(resposta.getProperty("nome").toString());
			usr.setIdade(Integer.parseInt(resposta.getProperty("idade").toString()));

			String foto = resposta.getProperty("foto").toString();

			byte[] bt = Base64.decode(foto, Base64.DEFAULT);
			usr.setFoto(bt);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return usr;
	}

	public boolean exculirUsuario(Usuario usr) {
		SoapObject buscarUsuarios = new SoapObject(NAMESPACE, EXCLUIR_USUARIO_POR_ID);
		buscarUsuarios.addProperty("id", usr.getId());

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

		envelope.setOutputSoapObject(buscarUsuarios);

		envelope.implicitTypes = true;

		HttpTransportSE http = new HttpTransportSE(URL);

		try {
			http.call("urn:" + EXCLUIR_USUARIO_POR_ID, envelope);

			SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();

			return Boolean.parseBoolean(resposta.toString());

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Usuario> BuscarTodosUsuarios() {

		List<Usuario> listaUsr = new ArrayList<Usuario>();

		SoapObject buscarUsuarios = new SoapObject(NAMESPACE, BUSCAR_TODOS);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

		envelope.setOutputSoapObject(buscarUsuarios);

		envelope.implicitTypes = true;

		HttpTransportSE http = new HttpTransportSE(URL);

		try {
			http.call("urn:" + BUSCAR_TODOS, envelope);

			if (envelope.getResponse() instanceof SoapObject) {
				SoapObject resposta = (SoapObject) envelope.getResponse();

				Usuario usr = new Usuario();

				usr.setId(Integer.parseInt(resposta.getProperty("id").toString()));
				usr.setNome(resposta.getProperty("nome").toString());
				usr.setIdade(Integer.parseInt(resposta.getProperty("idade").toString()));

				String foto = resposta.getProperty("foto").toString();

				byte[] bt = Base64.decode(foto, Base64.DEFAULT);
				usr.setFoto(bt);
				listaUsr.add(usr);
			} else {
				Vector<SoapObject> retorno = (Vector<SoapObject>) envelope.getResponse();

				for (SoapObject resposta : retorno) {

					Usuario usr = new Usuario();

					usr.setId(Integer.parseInt(resposta.getProperty("id").toString()));
					usr.setNome(resposta.getProperty("nome").toString());
					usr.setIdade(Integer.parseInt(resposta.getProperty("idade").toString()));

					String foto = resposta.getProperty("foto").toString();

					byte[] bt = Base64.decode(foto, Base64.DEFAULT);
					usr.setFoto(bt);
					listaUsr.add(usr);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return listaUsr;
	}

}
