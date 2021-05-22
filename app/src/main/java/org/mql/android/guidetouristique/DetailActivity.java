package org.mql.android.guidetouristique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.mql.android.guidetouristique.Models.Location;

import java.util.HashMap;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {

    private ImageView mLocationImage;
    private TextView mLocationName;
    private TextView mLocationDescription;
    private Location[] mLocations = new Location[] {
            new Location(1, "Fes", "Doyenne des villes impériales, Fes fut fondée en 789 après JC par Idriss Ier, un descendant du prophète. Son fils, le sultan Idriss II, décide en 809 d’y établir le siège de la dynastie. Dès 818, le sultan accueille dans sa cité 8 000 familles de musulmans andalous.Riche de ces multiples patrimoines religieux, culturels et architecturaux, Fes devient rapidement le centre religieux et culturel du Maroc.", "fes_univk.jpg"),
            new Location(2, "Meknes", "Fondée au XIe siècle par les Almoravides en tant qu'établissement militaire, Meknès devint capitale sous le règne de Moulay Ismaïl (1672-1727), fondateur de la dynastie alaouite. Il en fit une impressionnante cité de style hispano-mauresque ceinte de hautes murailles percées de portes monumentales qui montre aujourd'hui l'alliance harmonieuse des styles islamique et européen dans le Maghreb du XVIIe siècle.", "")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        mLocationImage = (ImageView) findViewById(R.id.location_cover);
        mLocationName = (TextView) findViewById(R.id.location_name);
        mLocationDescription = (TextView) findViewById(R.id.location_description);

        showLocation(intent.getStringExtra("currentLocation"));
    }

    private void showLocation(String location) {
        Location currentLocation = getLocation(location);
        mLocationImage.setImageResource(R.drawable.fes_univk);
        mLocationName.setText(currentLocation.getName());
        mLocationDescription.setText(currentLocation.getDescription());
    }

    private Location getLocation(String location) {
        for (int i = 0; i < mLocations.length; i++) {
            if (location.equals(mLocations[i].getName())) {
                return mLocations[i];
            }
        }
        return null;
    }
}