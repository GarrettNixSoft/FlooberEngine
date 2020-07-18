package com.floober.engine.particles.behavior.appearance;

import com.floober.engine.particles.Particle;
import com.floober.engine.util.math.MathUtil;
import com.floober.engine.util.math.RandomUtil;

public class FadeOutBehavior extends AppearanceBehavior {

	private final float initialAlpha, fadeDelay;

	public FadeOutBehavior(float initialAlpha, float fadeDelay) {
		this.initialAlpha = initialAlpha;
		this.fadeDelay = fadeDelay;
	}

	@Override
	public void initParticle(Particle particle) {
		particle.setAlpha(initialAlpha);
		setParticleColor(particle);
	}

	@Override
	public void updateParticle(Particle particle) {
		float time = particle.getElapsedTime();
		if (time > fadeDelay) {
			float life = particle.getLifeLength();
			float progress = (time - fadeDelay) / (life - fadeDelay);
			float percentage = initialAlpha - MathUtil.smoothstep(0, initialAlpha, progress);
			particle.setAlpha(initialAlpha * percentage);
		}
	}
}