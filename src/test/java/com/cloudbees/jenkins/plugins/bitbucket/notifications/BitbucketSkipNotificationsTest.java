package com.cloudbees.jenkins.plugins.bitbucket.notifications;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import com.cloudbees.jenkins.plugins.bitbucket.BitbucketSCMSource;
import com.cloudbees.jenkins.plugins.bitbucket.BitbucketSCMSourceContext;
import jenkins.scm.api.trait.SCMSourceContext;
import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

@WithJenkins
public class BitbucketSkipNotificationsTest {

    @Test
    public void shouldDecorateContext() {
        BitbucketSCMSourceContext mock = mock(BitbucketSCMSourceContext.class);
        BitbucketSkipNotifications trait = new BitbucketSkipNotifications();
        trait.decorateContext(mock);
        verify(mock).withNotificationsDisabled(true);
    }

    @Test
    public void shouldNotDecorateContext() {
        SCMSourceContext<?, ?> mock = mock(SCMSourceContext.class);
        BitbucketSkipNotifications trait = new BitbucketSkipNotifications();
        trait.decorateContext(mock);
        verifyNoInteractions(mock);
    }

    @Test
    public void shouldValidateDescriptor(JenkinsRule jenkinsRule) {
        BitbucketSkipNotifications.DescriptorImpl descriptor =
                jenkinsRule.jenkins.getDescriptorByType(BitbucketSkipNotifications.DescriptorImpl.class);
        assertThat(descriptor, notNullValue());
        assertThat(descriptor.getDisplayName(), is("Skip build status notifications"));
        assertThat(descriptor.getContextClass(), is(BitbucketSCMSourceContext.class));
        assertThat(descriptor.getSourceClass(), is(BitbucketSCMSource.class));
    }
}
