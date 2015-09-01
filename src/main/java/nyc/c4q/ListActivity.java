package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class ListActivity extends Activity {

    public ListView list;

    public static final Person[] PEOPLE = {
        new Person("Hannah",    "Abbott",          House.Hufflepuff),
        new Person("Katie",     "Bell",            House.Gryffindor),
        new Person("Susan",     "Bones",           House.Hufflepuff),
        new Person("Terry",     "Boot",            House.Ravenclaw),
        new Person("Lavender",  "Brown",           House.Gryffindor),
        new Person("Cho",       "Chang",           House.Ravenclaw),
        new Person("Michael",   "Corner",          House.Ravenclaw),
        new Person("Colin",     "Creevey",         House.Gryffindor),
        new Person("Marietta",  "Edgecombe",       House.Ravenclaw),
        new Person("Justin",    "Finch-Fletchley", House.Hufflepuff),
        new Person("Seamus",    "Finnigan",        House.Gryffindor),
        new Person("Anthony",   "Goldstein",       House.Ravenclaw),
        new Person("Hermione",  "Granger",         House.Gryffindor),
        new Person("Angelina",  "Johnson",         House.Gryffindor),
        new Person("Lee",       "Jordan",          House.Gryffindor),
        new Person("Neville",   "Longbottom",      House.Gryffindor),
        new Person("Luna",      "Lovegood",        House.Ravenclaw),
        new Person("Ernie",     "Macmillan",       House.Hufflepuff),
        new Person("Parvati",   "Patil",           House.Gryffindor),
        new Person("Padma",     "Patil",           House.Ravenclaw),
        new Person("Harry",     "Potter",          House.Gryffindor),
        new Person("Zacharias", "Smith",           House.Hufflepuff),
        new Person("Alicia",    "Spinnet",         House.Gryffindor),
        new Person("Dean",      "Thomas",          House.Gryffindor),
        new Person("Fred",      "Weasley",         House.Gryffindor),
        new Person("George",    "Weasley",         House.Gryffindor),
        new Person("Ginny",     "Weasley",         House.Gryffindor),
        new Person("Ron",       "Weasley",         House.Gryffindor)
    };



    int sortType = 0;
    boolean showColor = false;
    PersonAdapter personAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView) findViewById(R.id.list);
        final Button nameSortButton = (Button)findViewById(R.id.button_name);


        nameSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String label = ((Button) v).getText().toString();

                if (label.equals("Last, First")){
                    sortType = 1;
                    ((Button) v).setText("First Last");

                } else{
                    sortType = 0;
                    ((Button) v).setText("Last, First");
                }

                personAdapter.setSortType(sortType);
            }
        });

        Button colorButton = (Button)findViewById(R.id.button_color);
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String colorLabel = ((Button) v).getText().toString();

                if(colorLabel.equals(getResources().getString(R.string.show_color))){
                    showColor = true;
                    ((Button) v).setText(getResources().getString(R.string.hide_color));
                } else{
                    showColor = false;
                    ((Button) v).setText(getResources().getString(R.string.show_color));
                }

                personAdapter.setShowColors(showColor);
            }
        });

        ArrayList<Person> personList = new ArrayList<Person>(Arrays.asList(PEOPLE));

       personAdapter =
                new PersonAdapter (this, personList, sortType);

        list.setAdapter(personAdapter);


    }

    public class PersonAdapter extends ArrayAdapter <Person> {

        private int sortType = 0;
        private boolean showColor = false;

        public void setSortType(int sortType){
            this.sortType = sortType;
            if (sortType == 0){
                sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person lhs, Person rhs) {
                        return (lhs.getLastName() + ", " + lhs.getFirstName()).compareTo(rhs.getLastName() + ", "+ rhs.getFirstName());
                    }
                });
            }else if (sortType == 1){

                sort(new Comparator<Person>() {
                    @Override
                    public int compare(Person lhs, Person rhs) {
                        return (lhs.getFirstName() + " " + lhs.getLastName()).compareTo(rhs.getFirstName() + " " + rhs.getLastName());

                    }
                });

            }

            notifyDataSetChanged();
        }

        public void setShowColors(boolean showColor){
            this.showColor = showColor;
            notifyDataSetChanged();

        }

        public PersonAdapter (Context context, ArrayList<Person> users, int sortType) {
            super(context, 0, users);
            setSortType(sortType);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Person person = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_member, parent, false);
            }
            TextView tvName = (TextView) convertView.findViewById(R.id.text_name);
            TextView tvHouse = (TextView) convertView.findViewById(R.id.text_house);
            if(sortType == 1) {
                tvName.setText(person.getFirstName() + " " + person.getLastName());
            } else {
                tvName.setText(person.getLastName() + ", " + person.getFirstName());
            }
            House house = person.getHouse();
            tvHouse.setText(house.name());
            int color = 0;
            if(showColor){

                if(house.name().equals("Gryffindor")) {
                    color = getResources().getColor(R.color.gryffindor_red);
                } else if(house.name().equals("Ravenclaw")) {
                    color = getResources().getColor(R.color.ravenclaw_blue);
                } else if(house.name().equals("Hufflepuff")) {
                    color = getResources().getColor(R.color.hufflepuff_yellow);
                }else if(house.name().equals("Slytherin")) {
                    color = getResources().getColor(R.color.slytherin_green);
                }

            }

            convertView.setBackgroundColor(color);

            return convertView;
        }
    }

}
