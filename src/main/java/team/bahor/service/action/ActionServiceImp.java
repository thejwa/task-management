package team.bahor.service.action;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.bahor.entity.task.Action;
import team.bahor.repository.action.ActionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionServiceImp implements ActionService {
    private final ActionRepository actionRepository;

    public void create(Action action) {
        actionRepository.save(action);
    }

    public List<Action> getAllAction(Long id){
       return actionRepository.findAllByTaskId(id);
    }
}
