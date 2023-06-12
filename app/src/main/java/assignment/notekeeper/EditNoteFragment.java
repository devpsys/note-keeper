package assignment.notekeeper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import assignment.notekeeper.databinding.FragmentEditNoteBinding;

public class EditNoteFragment extends Fragment {

    private FragmentEditNoteBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentEditNoteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.back.setOnClickListener(v -> {
            requireActivity().onBackPressed();
        });

        binding.save.setOnClickListener(v -> {
            saveNote();
        });
    }

    private void saveNote() {
        String title = binding.title.getText().toString().trim();
        String note = binding.note.getText().toString().trim();

        if (title.isEmpty()) {
            message("Provide note's title to continue");
            return;
        }

        if (note.isEmpty()) {
            message("Provide note's body to continue");
            return;
        }

        Note newNote = new Note(title, note);
        NoteKeeper.notes.add(newNote);
        NoteKeeper.encode();

        binding.back.performClick();
    }

    private void message(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}