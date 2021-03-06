/*******************************************************************************
 * Copyright (c) 2011 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.cloudifysource.dsl.cloud;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.cloudifysource.dsl.DSLValidation;
import org.cloudifysource.dsl.internal.CloudifyDSLEntity;
import org.cloudifysource.dsl.internal.DSLValidationException;

/**
 * @author barakme
 * @since 2.0.0
 * 
 *        A cloud template is a group of settings that define a given configuration, available for a specific cloud. It
 *        can include physical machine properties (e.g. memory), operating system type, location, available cloud nodes
 *        and other settings.
 */
@CloudifyDSLEntity(name = "template", clazz = CloudTemplate.class, allowInternalNode = true, allowRootNode = false,
		parent = "cloud")
public class CloudTemplate {

	private String imageId;
	private int machineMemoryMB;
	private String hardwareId;
	private String locationId;
	private String localDirectory;
	private String keyFile;

	private int numberOfCores = 1;

	private Map<String, Object> options = new HashMap<String, Object>();
	private Map<String, Object> overrides = new HashMap<String, Object>();
	private Map<String, Object> custom = new HashMap<String, Object>();

	private FileTransferModes fileTransfer = FileTransferModes.SCP;
	private RemoteExecutionModes remoteExecution = RemoteExecutionModes.SSH;

	private String username;
	private String password;
	private String remoteDirectory;

	private boolean privileged = false;
	private String initializationCommand = null;

	private Map<String, String> env = new HashMap<String, String>();
	/**
	 * Gets the image ID.
	 * 
	 * @return The image ID
	 */
	public String getImageId() {
		return imageId;
	}

	/**
	 * Sets the image ID.
	 * 
	 * @param imageId The ID of the image to use
	 */
	public void setImageId(final String imageId) {
		this.imageId = imageId;
	}

	/**
	 * Gets the machine memory size in MB.
	 * 
	 * @return The machine memory size
	 */
	public int getMachineMemoryMB() {
		return machineMemoryMB;
	}

	/**
	 * Sets the machine memory size in MB.
	 * 
	 * @param machineMemoryMB The machine memory size
	 */
	public void setMachineMemoryMB(final int machineMemoryMB) {
		this.machineMemoryMB = machineMemoryMB;
	}

	/**
	 * Gets the hardware ID.
	 * 
	 * @return The ID of the hardware profile
	 */
	public String getHardwareId() {
		return hardwareId;
	}

	/**
	 * Sets the hardware ID.
	 * 
	 * @param hardwareId the ID of the hardware profile
	 */
	public void setHardwareId(final String hardwareId) {
		this.hardwareId = hardwareId;
	}

	/**
	 * Gets the location ID.
	 * 
	 * @return The location ID
	 */
	public String getLocationId() {
		return locationId;
	}

	/**
	 * Sets the location ID.
	 * 
	 * @param locationId The ID of this location
	 */
	public void setLocationId(final String locationId) {
		this.locationId = locationId;
	}

	/**
	 * Gets the machine's cores' number.
	 * 
	 * @return The machine's cores' number
	 */
	public int getNumberOfCores() {
		return numberOfCores;
	}

	/**
	 * Sets the number of cores on this machine.
	 * 
	 * @param numberOfCores The machine's cores' number
	 */
	public void setNumberOfCores(final int numberOfCores) {
		this.numberOfCores = numberOfCores;
	}

	/**
	 * Gets the configured options.
	 * 
	 * @return A map of configured options
	 */
	public Map<String, Object> getOptions() {
		return options;
	}

	/**
	 * Sets optional settings.
	 * 
	 * @param options A map of optional settings
	 */
	public void setOptions(final Map<String, Object> options) {
		this.options = options;
	}

	/**
	 * Gets the configured overrides.
	 * 
	 * @return A list of configured overrides
	 */
	public Map<String, Object> getOverrides() {
		return overrides;
	}

	/**
	 * Sets overriding settings. This is optional.
	 * 
	 * @param overrides A map of overriding settings
	 */
	public void setOverrides(final Map<String, Object> overrides) {
		this.overrides = overrides;
	}

	/**
	 * Gets the custom settings.
	 * 
	 * @return A map of custom settings
	 */
	public Map<String, Object> getCustom() {
		return custom;
	}

	/**
	 * Sets custom settings.
	 * 
	 * @param custom A map of custom settings
	 */
	public void setCustom(final Map<String, Object> custom) {
		this.custom = custom;
	}

	@Override
	public String toString() {
		return "CloudTemplate [imageId=" + imageId + ", machineMemoryMB=" + machineMemoryMB + ", hardwareId="
				+ hardwareId + ", locationId=" + locationId + ", numberOfCores=" + numberOfCores + ", options="
				+ options + ", overrides=" + overrides + ", custom=" + custom + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getRemoteDirectory() {
		return remoteDirectory;
	}

	public void setRemoteDirectory(final String remoteDirectory) {
		this.remoteDirectory = remoteDirectory;
	}

	public FileTransferModes getFileTransfer() {
		return fileTransfer;
	}

	public void setFileTransfer(final FileTransferModes fileTransfer) {
		this.fileTransfer = fileTransfer;
	}

	public RemoteExecutionModes getRemoteExecution() {
		return remoteExecution;
	}

	public void setRemoteExecution(final RemoteExecutionModes remoteExecution) {
		this.remoteExecution = remoteExecution;
	}

	public String getLocalDirectory() {
		return localDirectory;
	}

	public void setLocalDirectory(final String localDirectory) {
		this.localDirectory = localDirectory;
	}

	public String getKeyFile() {
		return keyFile;
	}

	public void setKeyFile(final String keyFile) {
		this.keyFile = keyFile;
	}

	@DSLValidation
	void validateDefaultValues()
			throws DSLValidationException {
		if (this.getRemoteDirectory() == null || this.getRemoteDirectory().trim().isEmpty()) {
			throw new DSLValidationException("Remote directory for template is missing");
		}

		if (StringUtils.isBlank(this.getLocalDirectory())) {
			throw new DSLValidationException("Local directory for template is missing");
		}

		if ("ENTER_KEY_FILE_NAME".equals(this.getKeyFile())) {
			throw new DSLValidationException(
					"Key file name field still has default configuration value of ENTER_KEY_FILE_NAME");
		}

	}

	/************
	 * True if services running in this template should have privileged access. This usually means that the service will
	 * run with higher Operating System permissions - root/sudoer on Linux, Administrator on Windows. Default is false.
	 * 
	 * @return true if services on this template will run in privileged mode.
	 */
	public boolean isPrivileged() {
		return privileged;
	}

	public void setPrivileged(final boolean privileged) {
		this.privileged = privileged;
	}

	/**************
	 * A command line that will be executed before the bootstrapping process of a machine from this template ends
	 * (before the Cloudify agent starts, after JDK and Cloudify are installed).
	 * 
	 * @return the initialization command line.
	 */
	public String getInitializationCommand() {
		return initializationCommand;
	}

	public void setInitializationCommand(final String initializationCommand) {
		this.initializationCommand = initializationCommand;
	}

	/*************
	 * Environment variables set for a specific template.
	 * 
	 * @return the environment variables.
	 */
	public Map<String, String> getEnv() {
		return env;
	}

	public void setEnv(final Map<String, String> env) {
		this.env = env;
	}

}
