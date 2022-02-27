package team.bahor.service.comment;

import team.bahor.dto.comment.CommentCreateDto;
import team.bahor.dto.comment.CommentDto;
import team.bahor.dto.comment.CommentUpdateDto;
import team.bahor.service.base.GenericCrudService;

public interface CommentService extends GenericCrudService<CommentDto, CommentCreateDto, CommentUpdateDto,Long> {
}
