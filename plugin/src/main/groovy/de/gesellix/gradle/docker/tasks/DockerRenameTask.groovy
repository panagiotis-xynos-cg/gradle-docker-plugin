package de.gesellix.gradle.docker.tasks

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

class DockerRenameTask extends DockerTask {

    @Input
    def containerId
    @Input
    def newName

    def result

    DockerRenameTask() {
        description = "Rename an existing container"
        group = "Docker"
    }

    @TaskAction
    def rename() {
        logger.info "docker rename"
        result = dockerClient.rename(getContainerId(), getNewName())
        return result
    }
}
