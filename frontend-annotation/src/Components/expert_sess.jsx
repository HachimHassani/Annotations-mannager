/* This example requires Tailwind CSS v2.0+ */
import { StarIcon } from '@heroicons/react/solid'
import { useState,useEffect } from 'react'
import * as React from 'react';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import { Link } from 'react-router-dom';

import axios from "axios";

import SketchExample from './ColorPickerModal';
import Navbar from './Home';
import Sidebar from './sidebar';

const reviews = [
  {
    id: 1,
    title: "Can't say enough good things",
    rating: 5,
    content: `
      <p>I was really pleased with the overall shopping experience. My order even included a little personal, handwritten note, which delighted me!</p>
      <p>The product quality is amazing, it looks and feel even better than I had anticipated. Brilliant stuff! I would gladly recommend this store to my friends. And, now that I think of it... I actually have, many times!</p>
    `,
    author: 'Risako M',
    date: 'May 16, 2021',
    datetime: '2021-01-06',
  },{
    id: 4,
    title: "Can't say enough good things",
    rating: 5,
    content: `
      <p>I was really pleased with the overall shopping experience. My order even included a little personal, handwritten note, which delighted me!</p>
      <p>The product quality is amazing, it looks and feel even better than I had anticipated. Brilliant stuff! I would gladly recommend this store to my friends. And, now that I think of it... I actually have, many times!</p>
    `,
    author: 'Risako M',
    date: 'May 16, 2021',
    datetime: '2021-01-06',
  },{
    id: 3,
    title: "Can't say enough good things",
    rating: 5,
    content: `
      I was really pleased with the overall shopping experience. My order even included a little personal, handwritten note, which delighted me!
      The product quality is amazing, it looks and feel even better than I had anticipated. Brilliant stuff! I would gladly recommend this store to my friends. And, now that I think of it... I actually have, many times!
    `,
    author: 'Risako M',
    date: 'May 16, 2021',
    datetime: '2021-01-06',
  },
  
  // More reviews...
]

function classNames(...classes) {
  return classes.filter(Boolean).join(' ')
}

export default function ExpertSession() {
  const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
  };
  const [open, setOpen] = React.useState(false);
  const  handleOpen = () => {setOpen(true)}
  const handleClose = () => setOpen(false);
  const [text,setText] = useState()
  const [addtext,setAddtext] = useState({title:'',content:''})

  const handleInput = (event) => {
    setAddtext({...addtext,[event.target.name]:event.target.value})

}
const getHeaders = () => {
  const token = localStorage.getItem("auth");
  return {headers :{    Authorization: `Bearer ${token}`}}
}
useEffect(() => {
  fetch("http://localhost:8080/expert/texts",header)
  .then(response => response.json())
  // 4. Setting *data* to the API DATA that we received from the response above
  .then(data => setText(data))
  },[])
const header = getHeaders();
function DeleteHandler(event,id){
  event.preventDefault()
  axios.delete('http://localhost:8080/admin/texts/'+id, header).then(response => console.log(response)).catch(err => console.log(err.status))

  window.location.reload(false)
}
// axios.get('http://localhost:8080/admin/texts/get',header).then(response => setText(response.data)).catch(err => console.log(err.status))

function handleCandidate(event,id){
  const header = getHeaders();
  console.log(header)
  event.preventDefault()
  
  axios.post('http://localhost:8080/expert/set-candidate/'+id,{title:text.title,content:text.content

  },header).then(response => console.log(response)).catch(err => console.log(err.status))
}
function handleAdd(event){
  const header = getHeaders();
  console.log(header)
  event.preventDefault()
  
  axios.post('http://localhost:8080/admin/texts',{title:addtext.titre,content:addtext.Text

  },header).then(response => console.log(response,addtext)).catch(err => console.log(err.status))
}
  return (
    <><Navbar></Navbar><Sidebar></Sidebar><div className="bg-white">
      <div style = {{marginTop:-67}} className="max-w-2xl mx-auto py-16 px-4 sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8">
        <div className="bg-white">
          <div className="-ml-4 -mt-2 flex items-center justify-between flex-wrap sm:flex-nowrap">
            <div className="ml-4 mt-2">
            </div>
            {/* <div className="ml-4 mt-2 flex-shrink-0">
              <button
              style = {{marginRight:203}}
                onClick={handleOpen}
                type="button"
                className="relative inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-emerald-400 hover:bg-emerald-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
              >
                Add new Text
              </button>
              <Modal
                open={open}
                onClose={() => { handleClose(); } }
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
                          Titre
                        </label>
                        <div className="mt-1 sm:mt-0 sm:col-span-2">
                          <input
                            onChange={handleInput}

                            type="text"
                            name="titre"
                            id="titre"
                            autoComplete="given-name"
                            className="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md" />
                        </div>
                      </div>



                      <div className="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
                        <label htmlFor="last-name" className="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">
                          Contenu                      </label>
                        <div className="mt-1 sm:mt-0 sm:col-span-2">
                          <textarea
                            onChange={handleInput}

                            type="text"
                            name="Text"
                            id="Text"
                            autoComplete="family-name"
                            className="max-w-lg block w-full shadow-sm focus:ring-indigo-500 focus:border-indigo-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md" />
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
                            onClick={handleAdd}
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
              </Modal>
            </div> */}
          </div>
        </div>
        <div className="mt-6 pb-10 border-t border-b border-gray-200 divide-y divide-gray-200 space-y-10">
          {text?.map((text) => (
            <div key={text.id} className="pt-10 lg:grid lg:grid-cols-12 lg:gap-x-8" style={{ marginBottom: -35 }}>
              <div className="lg:col-start-5 lg:col-span-8 xl:col-start-4 xl:col-span-9 xl:grid xl:grid-cols-3 xl:gap-x-8 xl:items-start">

                <div className="mt-4 lg:mt-6 xl:mt-0 xl:col-span-2">
                  <h3 className="text-sm font-medium text-gray-900">{text.title}</h3>

                  <div
                    className="mt-3 space-y-6 text-sm text-gray-500"
                    dangerouslySetInnerHTML={{ __html: text.content}}>
                  </div>

                </div>
              </div>

              {/* <div className="mt-6 flex items-center text-sm lg:mt-0 lg:col-start-1 lg:col-span-4 lg:row-start-1 lg:flex-col lg:items-start xl:col-span-3">
                <p className="font-medium text-gray-900">{review.author}</p>
                <time
                  dateTime={review.datetime}
                  className="ml-4 border-l border-gray-200 pl-4 text-gray-500 lg:ml-0 lg:mt-2 lg:border-0 lg:pl-0"
                >
                  {review.date}
                </time>
              </div> */}
              <div className="bg-white px-4 py-5 border-b border-gray-200 sm:px-6">
                <div className="-ml-4 -mt-2 flex items-center justify-between flex-wrap sm:flex-nowrap">

                  <div className="ml-4 mt-2 flex-shrink-0" style={{ marginLeft: 855 }}
                  >
                    <button
                      onClick={(e)=>handleCandidate(e,text.id)}
                      type="button"
                      className="relative inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                    >
                      <Link className = "text-white" to = "/CandidateSession">Candidate</Link>
                    </button>


                  </div>
                </div>
              </div>
            </div>
          ))}

        </div>

      </div>
    </div></>
  )
}
