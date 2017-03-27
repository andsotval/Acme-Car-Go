
package forms;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.URL;

public class BannerForm {

	private String url;


	public BannerForm() {
		super();
	}

	@URL
	@SafeHtml
	public String getUrl() {
		return this.url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

}
