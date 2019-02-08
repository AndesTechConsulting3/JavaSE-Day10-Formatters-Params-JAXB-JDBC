package org.andestech.learning.rfb19.g3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarException;

public class AppJAXB {

    public static void main(String[] args)
    {
        Book book =
                new Book(1869,"GG-864876","Лев Толстой","Война и Мир");

      try {

          JAXBContext ctx = JAXBContext.newInstance(Book.class);

          Marshaller marshaller = ctx.createMarshaller();
          marshaller.setProperty("jaxb.formatted.output", true);

          marshaller.marshal(book, new FileOutputStream("e:\\datas3\\book1.xml"));

      }
      catch (JAXBException | IOException ex){ex.printStackTrace();}

    }

}
