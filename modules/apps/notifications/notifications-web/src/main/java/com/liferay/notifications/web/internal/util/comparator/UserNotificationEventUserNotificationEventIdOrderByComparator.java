/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.notifications.web.internal.util.comparator;

import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Roberto Díaz
 */
public class UserNotificationEventUserNotificationEventIdOrderByComparator
	extends OrderByComparator<UserNotificationEvent> {

	public static UserNotificationEventUserNotificationEventIdOrderByComparator
		getInstance(boolean ascending) {

		if (ascending) {
			return _INSTANCE_ASCENDING;
		}

		return _INSTANCE_DESCENDING;
	}

	@Override
	public int compare(
		UserNotificationEvent userNotificationEvent1,
		UserNotificationEvent userNotificationEvent2) {

		int value = Long.compare(
			userNotificationEvent1.getUserNotificationEventId(),
			userNotificationEvent2.getUserNotificationEventId());

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return _ORDER_BY_ASC;
		}

		return _ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return _ORDER_BY_FIELDS;
	}

	private UserNotificationEventUserNotificationEventIdOrderByComparator(
		boolean ascending) {

		_ascending = ascending;
	}

	private static final
		UserNotificationEventUserNotificationEventIdOrderByComparator
			_INSTANCE_ASCENDING =
				new UserNotificationEventUserNotificationEventIdOrderByComparator(
					true);

	private static final
		UserNotificationEventUserNotificationEventIdOrderByComparator
			_INSTANCE_DESCENDING =
				new UserNotificationEventUserNotificationEventIdOrderByComparator(
					false);

	private static final String _ORDER_BY_ASC =
		"UserNotificationEvent.userNotificationEventId ASC";

	private static final String _ORDER_BY_DESC =
		"UserNotificationEvent.userNotificationEventId DESC";

	private static final String[] _ORDER_BY_FIELDS = {
		"userNotificationEventId"
	};

	private final boolean _ascending;

}