package com.example.rma_1_mirza_sabanovic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShowDatabase extends AppCompatActivity {

    ArrayList<Oils> OilList;

    OilsDatabse oilsDB;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_database);

        btn = findViewById(R.id.btnshow);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOilsListInBackground();
            }
        });

        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        oilsDB = Room.databaseBuilder(getApplicationContext(), OilsDatabse.class,
                "oilsDB").addCallback(myCallBack).build();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void getOilsListInBackground() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                OilList = (ArrayList<Oils>) oilsDB.getOilsDAO().getAllOils();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView recyclerView = findViewById(R.id.secondRecyclerView);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(ShowDatabase.this);
                        recyclerView.setLayoutManager(layoutManager);

                        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
                            @NonNull
                            @Override
                            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_oil, parent, false);
                                return new RecyclerView.ViewHolder(view) {
                                };
                            }


                            @Override
                            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                                Oils oil = OilList.get(position);
                                TextView oilNameTextView = holder.itemView.findViewById(R.id.oilNameTextView);
                                TextView oilValueTextView = holder.itemView.findViewById(R.id.oilValueTextView);
                                oilNameTextView.setText(oil.getOils());
                                oilValueTextView.setText(oil.getValue());
                            }

                            @Override
                            public int getItemCount() {
                                return OilList.size();
                            }
                        };

                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}