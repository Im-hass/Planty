import React from 'react';
import ReservationTime from 'components/atoms/common/ReservationTime/ReservationTime';

function Test() {
	const Time = [
		'10:00',
		'10:30',
		'11:00',
		'11:30',
		'12:00',
		'12:30',
		'13:00',
		'13:30',
		'14:00',
		'14:30',
		'15:00',
		'15:30',
		'16:00',
		'16:30',
		'17:00',
		'17:30',
	];
	const reservationInfo: { isActivate: boolean } = {
		isActivate: true, // true, false 커스터마이징
	};
	return (
		<div>
			<div>TEST</div>
			<div className="ReservationGrid">
				{Time.map((time, index) => (
					// eslint-disable-next-line react/no-array-index-key
					<ReservationTime key={index} time={time} isActivate={reservationInfo.isActivate} />
				))}
			</div>
		</div>
	);
}

export default Test;