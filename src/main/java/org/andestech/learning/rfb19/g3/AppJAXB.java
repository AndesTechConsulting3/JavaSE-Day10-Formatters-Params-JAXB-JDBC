package org.andestech.learning.rfb19.g3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.JarException;

public class AppJAXB {

    public static void main(String[] args)
    {
        Book book =
                new Book(1869,"GG-864876","Лев Толстой","Война и Мир");

        Book book2 =
                new Book(1889,"GT-823464876","Лев Толстой","Крейцерова соната");


        Library library = new Library();
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);
        library.setBookList(books);




        Book bookFromXml = null;

      try {

          JAXBContext ctx = JAXBContext.newInstance(Book.class);

          Marshaller marshaller = ctx.createMarshaller();
          marshaller.setProperty("jaxb.formatted.output", true);

          marshaller.marshal(book, new FileOutputStream(
                  "e:\\datas3\\book1.xml"));

          //--------------------------

          Unmarshaller unmarshaller = ctx.createUnmarshaller();

          bookFromXml = (Book) unmarshaller.unmarshal(
                  new FileInputStream("e:\\datas3\\book1.xml"));

          System.out.println(bookFromXml);


          //------------------------------------------------------------

          JAXBContext ctx2 = JAXBContext.newInstance(Library.class);

          Marshaller marshaller2 = ctx2.createMarshaller();
          marshaller2.setProperty("jaxb.formatted.output", true);

          marshaller2.marshal(library, new FileOutputStream(
                  "e:\\datas3\\library1.xml"));

      }
      catch (JAXBException | IOException ex){ex.printStackTrace();}

    }

}
