package com.capstone.uniculture.dto.Post;

import com.capstone.uniculture.dto.Comment.CommentResponseDto;
import com.capstone.uniculture.entity.Post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostListDto {

    private Long postId;
    private String title;
    private String content;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private String writerName;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder
    public PostListDto(Long postId, String title, String content, Integer viewCount, Integer commentCount, Integer likeCount, String writerName, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.writerName = writerName;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public static PostListDto fromEntity(Post post){
        return PostListDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .viewCount(post.getViewCount())
                .commentCount(post.getCommentCount())
                .likeCount(post.getLikeCount())
                .writerName(post.getMember().getNickname())
                .createDate(post.getCreatedDate())
                .modifiedDate(post.getModifiedDate())
                .build();
    }
}
