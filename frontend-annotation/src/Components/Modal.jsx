
import { useLayoutEffect, useRef, useState } from 'react'
import Navbar from "./Home";
import Sidebar from './sidebar'
import * as React from 'react';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import SketchExample from './ColorPickerModal';
export default function Classes() {

    const [open, setOpen] = React.useState(false);
    const  handleOpen = () => {setOpen(true)}
    const handleClose = () => setOpen(false);
    return(                        <Modal
        open={open}
        onClose= {()=>{handleClose()}}
        aria-labelledby="modal-modal-color"
        aria-describedby="modal-modal-description"
    >
        <Box sx={style}>
        <div className="pt-8 space-y-6 sm:pt-10 sm:space-y-5">
<div>
<h3 className="text-lg leading-6 font-medium text-gray-900">Personal Information</h3>
<p className="mt-1 max-w-2xl text-sm text-gray-500">Use a permanent address where you can receive mail.</p>
</div>
<div className="space-y-6 sm:space-y-5">
<div className="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
<label htmlFor="first-name" className="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">
Name
</label>
<div className="mt-1 sm:mt-0 sm:col-span-2">
<input
type="text"
name="first-name"
id="first-name"
autoComplete="given-name"
className="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
/>
</div>
</div>

<div className="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
<label htmlFor="last-name" className="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">
Color
</label>
<div className="mt-1 sm:mt-0 sm:col-span-2">
<SketchExample sendDataToParent = {handleCallback}></SketchExample>
</div>
</div>

<div className="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
<label htmlFor="last-name" className="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">
Shortkey
</label>
<div className="mt-1 sm:mt-0 sm:col-span-2">
<input
type="text"
name="last-name"
id="last-name"
autoComplete="family-name"
className="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md"
/>
</div>
</div>

<div className="pt-5">
<div className="flex justify-end">
<button
type="button"
className="bg-white py-2 px-4 border border-gray-300 rounded-md shadow-sm text-sm font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
>
Cancel
</button>
<button
type="submit"
className="ml-3 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
>
Save
</button>
</div>
</div>
</div>
</div>
        </Box>
    </Modal> )}