/******************************************************************************* 
 * Copyright (c) 2010 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package org.jboss.tools.esb.validator.test;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.jboss.tools.esb.validator.ESBValidatorMessages;
import org.jboss.tools.test.util.JobUtils;
import org.jboss.tools.tests.AbstractResourceMarkerTest;

/**
 * @author Viacheslav Kabanovich
 */
public class ValidationTest extends ESBTest {

	public void test0() throws Exception {
		JobUtils.waitForIdle();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
	}
	/**
	 *  FTP Listener cannot reference FS Channel.
	 * 
	 * @throws Exception
	 */
	public void testIncompatibleChannelReference() throws Exception {
		IFile file = project.getFile("esbcontent/META-INF/jboss-esb-01.xml");
		AbstractResourceMarkerTest.assertMarkerIsCreated(file, AbstractResourceMarkerTest.MARKER_TYPE, ESBValidatorMessages.LISTENER_REFERENCES_INCOMPATIBLE_CHANNEL, 13);
		int markerNumbers = getMarkersNumber(file);
		assertEquals("jboss-esb-01.xml should have one error marker.", markerNumbers, 1);
	}

	public void testBusenessRulesProcessor() throws Exception {
		IFile file = project.getFile("esbcontent/META-INF/jboss-esb-brp-broken.xml");
		AbstractResourceMarkerTest.assertMarkerIsCreated(file, AbstractResourceMarkerTest.MARKER_TYPE, ESBValidatorMessages.INVALID_RULE_SET_FOR_RULE_LANGUAGE, 52);
		AbstractResourceMarkerTest.assertMarkerIsCreated(file, AbstractResourceMarkerTest.MARKER_TYPE, ESBValidatorMessages.INVALID_RULE_AUDIT_TYPE_AND_INTERVAL, 34);
		AbstractResourceMarkerTest.assertMarkerIsCreated(file, AbstractResourceMarkerTest.MARKER_TYPE, ESBValidatorMessages.INVALID_OBJECT_PATH_WRONG_LOCATION, 58);
		int markerNumbers = getMarkersNumber(file);
		assertEquals("jboss-esb-brp-broken.xml should have 2 error markers.", markerNumbers, 3);
	}

	/**
	 * 
	 * @throws Exception
	 */
//	public void testMultipleDisposeParameters() throws Exception {
//		IFile file = project.getFile("JavaSource/org/jboss/jsr299/tck/tests/implementation/disposal/method/definition/broken/multiParams/SpiderProducer_Broken.java");
//		AbstractResourceMarkerTest.assertMarkerIsCreated(file, AbstractResourceMarkerTest.MARKER_TYPE, ESBValidatorMessages.MULTIPLE_DISPOSING_PARAMETERS, 30, 30);
//	}

	public static int getMarkersNumber(IResource resource) {
		return AbstractResourceMarkerTest.getMarkersNumberByGroupName(resource, null);
	}

}