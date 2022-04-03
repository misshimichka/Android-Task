package com.samsung.samsungtask.services;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.firebase.ui.database.ClassSnapshotParser;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.samsung.samsungtask.models.Task;
import com.samsung.samsungtask.models.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class DatabaseService {
    public static FirebaseDatabase getDatabase() {
        return FirebaseDatabase.getInstance("https://samsung-task-default-rtdb.europe-west1.firebasedatabase.app/");
    }

    public static com.google.android.gms.tasks.Task<Void> remove(String ref) {
        return getDatabase()
                .getReference(ref)
                .removeValue();
    }

    public static FirebaseRecyclerOptions<Task> getUserOptions() {
        Query query = getDatabase().getReference("new-users/" + Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid());
        ClassSnapshotParser<Task> parser = new ClassSnapshotParser<>(Task.class);

        return new FirebaseRecyclerOptions.Builder<Task>()
                .setQuery(query, parser)
                .build();
    }

    public static void createNewTask(String taskName, String info, String importance, String personName, String time) {
        getDatabase()
                .getReference("new-users/" + Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                .push()
                .setValue(new Task(personName, taskName, info, importance, time) {
                });
    }
}