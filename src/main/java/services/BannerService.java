
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import domain.Banner;
import forms.BannerForm;
import repositories.BannerRepository;

@Service
@Transactional
public class BannerService {
	// Managed repository -----------------------------------------------------

	@Autowired
	private BannerRepository	bannerRepository;

	// Supporting services ----------------------------------------------------

	// Validator --------------------------------------------------------------
	private Validator			validator;


	// Constructors -----------------------------------------------------------

	public BannerService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------
	public Banner create() {
		final Banner res = new Banner();
		return res;
	}

	public Collection<Banner> findAll() {
		Collection<Banner> result;

		result = this.bannerRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Banner findOne(final int bannerId) {
		Assert.isTrue(bannerId != 0);

		Banner result;

		result = this.bannerRepository.findOne(bannerId);
		Assert.notNull(result);

		return result;
	}

	public Banner save(final Banner banner) {
		Assert.notNull(banner);

		Banner result;

		result = this.bannerRepository.save(banner);

		return result;
	}

	public void delete(final Banner banner) {
		Assert.notNull(banner);
		Assert.isTrue(banner.getId() != 0);
		Assert.isTrue(this.bannerRepository.exists(banner.getId()));

		this.bannerRepository.delete(banner);
	}

	// Other business methods -------------------------------------------------

	public Banner getOnlyBanner() {
		return this.findAll().iterator().next();
	}

	public Banner reconstruct(final BannerForm bannerForm, final BindingResult binding) {
		final Banner result = this.create();
		result.setUrl(bannerForm.getUrl());
		return this.save(result);
	}
}
