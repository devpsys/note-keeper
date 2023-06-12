package assignment.notekeeper;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import assignment.notekeeper.databinding.NoteItemBinding;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.BindingHolder> {

    @NonNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BindingHolder(NoteItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull BindingHolder holder, int position) {
        holder.bind(NoteKeeper.notes.get(position));
    }

    @Override
    public int getItemCount() {
        return NoteKeeper.notes.size();
    }

    class BindingHolder extends RecyclerView.ViewHolder {

        TextView title, note;

        public BindingHolder(@NonNull NoteItemBinding itemView) {
            super(itemView.getRoot());
            title = itemView.title;
            note = itemView.note;
        }

        public void bind(Note note) {
            title.setText(note.getTitle());
            this.note.setText(note.getNote());
        }
    }
}
