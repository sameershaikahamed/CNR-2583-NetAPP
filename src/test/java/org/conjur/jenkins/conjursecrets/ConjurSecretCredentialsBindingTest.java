package org.conjur.jenkins.conjursecrets;

import com.cloudbees.plugins.credentials.CredentialsStore;
import org.jenkinsci.plugins.credentialsbinding.MultiBinding.MultiEnvironment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ ConjurSecretCredentialsBinding.class })
public class ConjurSecretCredentialsBindingTest {

	public CredentialsStore store;

	@Mock
	public ConjurSecretCredentialsBinding binding;


	@Test
	public void testBind() throws IOException, InterruptedException {

		Map<String, String> secretVals=new HashMap<>();
		MultiEnvironment env = new MultiEnvironment(secretVals);
		when(binding.bind(any(), any(), any(), any())).thenReturn(env);
		assertTrue(binding.bind(any(), any(), any(), any()) instanceof MultiEnvironment);
	}

}
