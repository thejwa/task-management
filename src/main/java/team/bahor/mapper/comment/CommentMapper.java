package team.bahor.mapper.comment;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.comment.CommentCreateDto;
import team.bahor.dto.comment.CommentDto;
import team.bahor.dto.comment.CommentUpdateDto;
import team.bahor.entity.task.Comment;
import team.bahor.mapper.base.AbstractMapper;
@Component
@Mapper(componentModel = "spring")
public interface CommentMapper extends AbstractMapper<Comment, CommentDto, CommentCreateDto, CommentUpdateDto>  {
}
