/*
 * Copyright (C) 2018 Toshiaki Maki <makingx@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package am.ik.yavi.constraint;

import java.util.function.Predicate;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongConstraintTest {
	private LongConstraint<Long> constraint = new LongConstraint<>();

	@Test
	public void greaterThan() {
		Predicate<Long> predicate = constraint.greaterThan(100L).predicates().peekFirst()
				.predicate();
		assertThat(predicate.test(101L)).isTrue();
		assertThat(predicate.test(100L)).isFalse();
	}

	@Test
	public void greaterThanOrEqual() {
		Predicate<Long> predicate = constraint.greaterThanOrEqual(100L).predicates()
				.peekFirst().predicate();
		assertThat(predicate.test(101L)).isTrue();
		assertThat(predicate.test(100L)).isTrue();
		assertThat(predicate.test(99L)).isFalse();
	}

	@Test
	public void lessThan() {
		Predicate<Long> predicate = constraint.lessThan(100L).predicates().peekFirst()
				.predicate();
		assertThat(predicate.test(99L)).isTrue();
		assertThat(predicate.test(100L)).isFalse();
	}

	@Test
	public void lessThanOrEqual() {
		Predicate<Long> predicate = constraint.lessThanOrEqual(100L).predicates()
				.peekFirst().predicate();
		assertThat(predicate.test(99L)).isTrue();
		assertThat(predicate.test(100L)).isTrue();
		assertThat(predicate.test(101L)).isFalse();
	}
}