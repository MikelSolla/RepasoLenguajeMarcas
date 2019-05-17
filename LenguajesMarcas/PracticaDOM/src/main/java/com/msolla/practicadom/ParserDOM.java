/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msolla.practicadom;

import com.msolla.practicadom.Alojamiento;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author 1gdaw08
 */
public class ParserDOM {
    
    private Document dom;
    private List<Alojamiento> alojamiento;
    
    public ParserDOM(){
        alojamiento=new ArrayList<>();
        cargarDatos();
        crearDocumento();
    }
    
    private void cargarDatos(){
    alojamiento.add((Alojamiento) alojamiento);
    }
    
    private void crearDocumento() {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();

            dom.setXmlStandalone(true);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
    
    private void crearArbolDOM(){
    Element raiz =dom.createElement("alojamientos");
    dom.appendChild(raiz);
    for(Alojamiento alojamiento :alojamiento){
        Element elemento = crearElementoAlojamiento(alojamiento);
        raiz.appendChild(elemento);
    }
}
    private Element crearElementoAlojamiento(Alojamiento alojamineto){
        Element elementoAlojamiento=dom.createElement("alojamineto");
        
        Element elementoID = dom.createElement("ID");
        Text textoID = dom.createTextNode(alojamineto.getId());
        elementoID.appendChild(textoID);
        
        Element elementoTipo = dom.createElement("tipo");
        Text textoTipo=dom.createTextNode(alojamineto.getTipo());
        elementoTipo.appendChild(textoTipo);
        
        Element elementoNombre =dom.createElement("nombre");
        Text textoNombre =dom.createTextNode(alojamineto.getNombre());
        elementoNombre.appendChild(textoNombre);
        
        Element elementoMunicipio = dom.createElement("municipio");
        Text textoMunicipio=dom.createTextNode(alojamineto.getMunicipio());
        elementoMunicipio.appendChild(textoMunicipio);
        
        Element elementoWeb =dom.createElement("web");
        Text textoWeb =dom.createTextNode(alojamineto.getWeb());
        elementoWeb.appendChild(textoWeb);
        
        
                return elementoAlojamiento;
    }
    public void run(){
        crearArbolDOM();
        exportarFichero();
    }
    
    private void exportarFichero(){
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://www.dadesobertes.gva.es/storage/f/file/20170515215359/centros-educativos---2016-2017.xml}indent-amount", "4");

            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

            Result output = new StreamResult(new File("../Alojamientos.xml"));
            Source input = new DOMSource(dom);

            transformer.transform(input, output);

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
