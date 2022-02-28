package team.bahor.service.comment;

import org.springframework.stereotype.Service;
import team.bahor.dto.comment.CommentCreateDto;
import team.bahor.dto.comment.CommentDto;
import team.bahor.dto.comment.CommentUpdateDto;
import team.bahor.mapper.comment.CommentMapper;
import team.bahor.repository.comment.CommentRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.CommentValidator;

import java.util.List;

@Service
public class CommentServiceImp extends AbstractService<CommentRepository, CommentMapper, CommentValidator> implements CommentService {
    public CommentServiceImp(CommentMapper mapper, CommentValidator validator, CommentRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public Long create(CommentCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(CommentUpdateDto updateDto) {

    }

    @Override
    public CommentDto get(Long id) {
        return null;
    }

    @Override
    public List<CommentDto> getAllTasksForColumn(Long id) {
        return null;
    }

    public List<CommentDto> getAllForTask(Long id) {
        return mapper.toDto(repository.getByIdForTask(id));
    }
}
