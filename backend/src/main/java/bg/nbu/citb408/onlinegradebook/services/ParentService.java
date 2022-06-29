package bg.nbu.citb408.onlinegradebook.services;

import bg.nbu.citb408.onlinegradebook.repositories.ParentRepository;
import bg.nbu.citb408.onlinegradebook.repositories.UserRepository;
import bg.nbu.citb408.onlinegradebook.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class ParentService {
    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Parent> findAll() {
        List<Parent> parents = parentRepository.findAll();
        return parents;
    }

    public void addParent(@ModelAttribute Parent parent) {
        userRepository.save(parent.getUser());
        parentRepository.save(parent);
    }

    public Parent findParentById(@PathVariable("id") int id) {
        Parent parent = parentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid parent Id:" + id));
        return parent;
    }

    public void updateParent(@ModelAttribute Parent parent) throws Exception {
        Parent parentInDB = parentRepository.findById(parent.getId()).orElse(null);
        if (parentInDB != null) {
            parentInDB.setUser(parent.getUser());
            parentInDB.setStudents(parent.getStudents());
            userRepository.save(parentInDB.getUser());
            parentRepository.save(parentInDB);
        } else {
            throw new Exception("Parent not found");
        }
    }

    public void deleteParent(@PathVariable("id") int id) {
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid parent Id:" + id));
        parentRepository.delete(parent);
    }
}
