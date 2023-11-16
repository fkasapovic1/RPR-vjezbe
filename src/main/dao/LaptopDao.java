import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface LaptopDao {
    void dodajLaptopUListu(Laptop laptop);

    Laptop dodajLaptopUFile(Laptop laptop) throws IOException;

    Laptop getLaptop(String procesor);

    void napuniListu(ArrayList<Laptop> l);

    ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException;
}