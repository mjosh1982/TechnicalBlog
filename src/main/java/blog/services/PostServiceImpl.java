package blog.services;

import blog.common.Constants;
import blog.common.FileOperations;
import blog.common.PostsManager;
import blog.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private List<Post> postList = new ArrayList<Post>();
    private PostsManager postsManager;


    public PostServiceImpl() {
//        postList.add(new Post(1L, "This is post 1", "This is content of post1"));
//        postList.add(new Post(2L, "This is post 2", "This is content of post2"));
//        postList.add(new Post(3L, "This is post 3", "This is content of post3"));
//        postList.add(new Post(4L, "This is post 4", "This is content of post4"));
//        postList.add(new Post(5L, "This is post 5", "This is content of post5"));
//        postList.add(new Post(6L, "This is post 6", "This is content of post6"));
//        postList.add(new Post(7L, "This is post 7", "This is content of post7"));
        postsManager = new PostsManager();
    }

    @Override
    public Post create(Post post) {
        FileOperations.getInstance().writeToFile(Constants.POST_FILE_PREFIX, post, post.getTitle());
        return post;
    }

    @Override
    public List<Post> findAll() {
        return postsManager.readAllPosts();
    }

    @Override
    public List<Post> firstThreePosts() {
        return postsManager.getThreePosts();
    }

    @Override
    public Post findById(String id) {
        return null;
    }

    @Override
    public Post editPost(Post post) {
        return null;
    }

    @Override
    public void deleteById(Post post) {
        postsManager.deletePost(post.getTitle());
    }
}
