package org.jenkinsci.plugins.github.notifications;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import jenkins.scm.api.trait.SCMSourceContext;
import org.jenkinsci.plugins.github_branch_source.GitHubSCMSource;
import org.jenkinsci.plugins.github_branch_source.GitHubSCMSourceContext;
import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

@WithJenkins
public class GithubSkipNotificationsTest {

    @Test
    public void shouldDecorateContext() {
        GitHubSCMSourceContext mock = mock(GitHubSCMSourceContext.class);
        GithubSkipNotifications trait = new GithubSkipNotifications();
        trait.decorateContext(mock);
        verify(mock).withNotificationsDisabled(true);
    }

    @Test
    public void shouldNotDecorateContext() {
        SCMSourceContext<?, ?> mock = mock(SCMSourceContext.class);
        GithubSkipNotifications trait = new GithubSkipNotifications();
        trait.decorateContext(mock);
        verifyNoInteractions(mock);
    }

    @Test
    public void shouldValidateDescriptor(JenkinsRule jenkinsRule) {
        GithubSkipNotifications.DescriptorImpl descriptor =
                jenkinsRule.jenkins.getDescriptorByType(GithubSkipNotifications.DescriptorImpl.class);
        assertThat(descriptor, notNullValue());
        assertThat(descriptor.getDisplayName(), is("Skip build status notifications"));
        assertThat(descriptor.getContextClass(), is(GitHubSCMSourceContext.class));
        assertThat(descriptor.getSourceClass(), is(GitHubSCMSource.class));
    }
}
