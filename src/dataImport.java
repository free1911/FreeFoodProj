import java.util.ArrayList;

public class dataImport {
    private ArrayList<Event> dataBase=new ArrayList<>();
    public dataImport(){

        //Just a demo
        for(int i=0;i<10;i++) {
            Event e = new Event();
            //edit info
            e.date = "04/22/2017";
            e.title = "HACKRON";
            e.source = "www.hakron.io";
            e.discription = "hacking,food,prizes";
            e.hoster = "The bit factory";
            e.location = "Akron";
            e.kindOfFood = "Sandwich";
            e.id=i;
            //add new element to the list
            dataBase.add(e);
        }
        //
    }

    public ArrayList<Event> getDataBase() {
        return dataBase;
    }
}
