package message.resp;



import java.util.List;

public class NewsMessage extends BaseMessage {
	// 鍥炬枃娑堟伅涓暟锛岄檺鍒朵负10鏉′互鍐�
	private int ArticleCount;
	// 澶氭潯鍥炬枃娑堟伅淇℃伅锛岄粯璁ょ涓�涓猧tem涓哄ぇ鍥�
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

}
