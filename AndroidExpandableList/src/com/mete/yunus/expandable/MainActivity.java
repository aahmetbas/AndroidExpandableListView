package com.mete.yunus.expandable;

import java.util.ArrayList;
import java.util.HashMap;

import com.mete.yunus.expandable.adapter.ExpListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class MainActivity extends Activity {

	ExpandableListView expListView;
	ArrayList<String> basliklar;
	HashMap<String, ArrayList<String>> icerik;
	
	int lastPosition = -1;
	
	ExpListAdapter adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		expListView = (ExpandableListView) findViewById(R.id.exp_list);
		veriYolla();
		
		adapter = new ExpListAdapter(this, basliklar, icerik);
		
		expListView.setAdapter(adapter);
		
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
			
			@Override
			public void onGroupExpand(int groupPosition) {
				// TODO Auto-generated method stub
				if (lastPosition != -1 && lastPosition != groupPosition) {
					expListView.collapseGroup(lastPosition);
				}
				lastPosition = groupPosition;
			}
		});
		
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
			
			@Override
			public void onGroupCollapse(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public void veriYolla(){
		basliklar = new ArrayList<String>();
		icerik = new HashMap<String, ArrayList<String>>();
		
		basliklar.add("2013 En Ýyi 10 Filmi");
		basliklar.add("2013 En Ýyi 10 Oyunu");
		
		ArrayList<String> filmler = new ArrayList<String>();
		filmler.add("1. 12 Years a Slave");
		filmler.add("2. Gravity");
		filmler.add("3. American Hustle");
		filmler.add("4. The Wolf of Wall Street");
		filmler.add("5. Dallas Buyers Club");
		filmler.add("6. Her");
		filmler.add("7. The Hunger Games: Catching Fire");
		filmler.add("8. Inside Llewyn Davis");
		filmler.add("9. Short Term 12");
		filmler.add("10. Frozen");
		
		ArrayList<String> oyunlar = new ArrayList<String>();
		oyunlar.add("1. The Last of Us");
		oyunlar.add("2. Tomb Raider");
		oyunlar.add("3. Bioshoch Infinite");
		oyunlar.add("4. GTA V");
		oyunlar.add("5. Super Mario 3D World");
		oyunlar.add("6. Battlefield 4");
		oyunlar.add("7. Assassin Credd: Black Flag");
		oyunlar.add("8. Fire Emblem: Awakening");
		oyunlar.add("9. The Legend of Zelda: A Link Between Worlds");
		oyunlar.add("10. Gone Home");
		
		icerik.put(basliklar.get(0), filmler);
		icerik.put(basliklar.get(1), oyunlar);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
