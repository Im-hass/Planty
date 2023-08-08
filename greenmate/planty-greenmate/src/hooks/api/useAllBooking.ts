import { useState, useEffect } from 'react';
import { IConsulting } from 'types/subscribe';
import { findAllBookingApi } from 'utils/api/subscribe';

const useAllBooking = () => {
	const [bookings, setBookings] = useState<IConsulting[]>([]);

	const fetchData = async () => {
		try {
			const response = await findAllBookingApi();
			setBookings(response.data);
		} catch (error) {
			console.error('에러', error);
		}
	};

	useEffect(() => {
		fetchData();
	}, []);

	return bookings;
};

export default useAllBooking;
